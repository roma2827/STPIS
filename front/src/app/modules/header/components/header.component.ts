import {Component, OnDestroy, OnInit, TemplateRef} from '@angular/core';
import {User} from '../../models/user';
import {LoginModel} from '../../models/login.model';
import {Subscription} from 'rxjs';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {AuthToken, UserService} from '../../../services/user.service';
import {StorageService} from '../../../services/storage.service';
import {FormBuilder, Validators} from '@angular/forms';



@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {

  public loginModel: LoginModel = {
    username: null,
    password: null
  };
  public user: User;
  private subscriptions: Subscription[] = [];
  public editableUs: User = new User();
  public modalRegistrationRef: BsModalRef;
  public modalSignInRef: BsModalRef;
  public form: any;

  constructor(
    private  userService: UserService,
    private modalService: BsModalService,
    private storageService: StorageService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    this.form = this.formBuilder.group({
      login: ['', [Validators.required, Validators.pattern('^[a-zA-Z][a-zA-Z0-9-_\\.]{3,20}$')]],
      password: ['', [Validators.required, Validators.pattern('^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$'),
      Validators.minLength(5)]]
    });
  }

  public _closeSignInModal(): void {
    this.modalSignInRef.hide();
  }

  public _openSignInModal(template: TemplateRef<any>): void {
    this.modalSignInRef = this.modalService.show(template);
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  public _login(): void {
    this.userService.generateToken(this.loginModel)
      .subscribe((authToken: AuthToken) => {
        if (authToken.token) {
          this.storageService.setToken(authToken.token);
          this.userService.getAuthorizedUser()
            .subscribe((user: User) => {
              this.storageService.setCurrentUser(user);
              this._closeSignInModal();
            });
        }
      }, (error) => {
        if (error.status === 401) {
          alert('Incorrect login or password');
        } else {
          alert(error.message);
        }
      });
  }

  public logout(): void {
    this.storageService.clearToken();

    this.storageService.setCurrentUser(null);
  }

  // Registration
  public _openRegistrationModal(template: TemplateRef<any>): void {
    this._closeSignInModal();
    this.modalRegistrationRef = this.modalService.show(template);
  }

  public _closeRegistrationModal(): void {
    this.modalRegistrationRef.hide();
  }

  public _addUser(): void {
    if (!this.form.invalid) {
      this.subscriptions.push(this.userService.saveUser(this.editableUs).subscribe(() => {
        this._closeRegistrationModal();
        this.loginModel.username = this.editableUs.login;
        this.loginModel.password = this.editableUs.password;
        this._login();
        this.refreshUs();
      }));
    } else {
      alert('Please input valid credentials');
    }
  }

  private refreshUs(): void {
    this.editableUs = new User();
  }
}
