import {Component, OnDestroy, OnInit, TemplateRef} from '@angular/core';
import {Service} from '../models/service';
import {Subscription} from 'rxjs';
import {StorageService} from '../../services/storage.service';
import {ServicesService} from '../../services/services.service';
import {FormBuilder} from '@angular/forms';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';
import {SubscriptionService} from '../../services/subscription.service';
import {Subscriptions} from '../models/subscriptions';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit, OnDestroy {

  public services: Service[];
  private subscriptions: Subscription[] = [];
  public modalRef: BsModalRef;
  public form: any;
  public editableS: Service = new Service();
  public editableSub: Subscriptions = new Subscriptions();

  constructor(
    private storageService: StorageService,
    private modalService: BsModalService,
    private servicesService: ServicesService,
    private subscriptionService: SubscriptionService,
    private formBuilder: FormBuilder,
    private loadingService: Ng4LoadingSpinnerService
  ) {}


  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  ngOnInit() {
    this.loadServices();
    this.form = this.formBuilder.group({
    });
  }


  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public _addService(): void {
    if (!this.form.invalid) {
      this.loadingService.show();
      this.subscriptions.push(this.servicesService.createService(this.editableS).subscribe(() => {
        this._updateServices();
        this.refreshS();
        this.loadingService.hide();
        this._closeModal();
      }));
    }
  }

  public _updateServices(): void {
    this.loadServices();
  }

  private refreshS(): void {
    this.editableS = new Service();
  }

  private loadServices(): void {
    this.subscriptions.push(this.servicesService.getServices().subscribe(data => {
      this.services = data as Service[];
    }));
  }

  private subscribe(): void {
    this.subscriptions.push(this.subscriptionService.subscribe(this.editableSub).subscribe(() => {
    }));
  }
}
