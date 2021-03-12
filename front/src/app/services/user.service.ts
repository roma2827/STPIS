import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {User} from '../modules/models/user';
import {HttpClient} from '@angular/common/http';
import {LoginModel} from '../modules/models/login.model';

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api/user', user);
  }

  getUserByLogin(login: string): Observable<User> {
    return this.http.get<User>('/api/user/login/' + login);
  }

  public generateToken(login: LoginModel): Observable<AuthToken> {
    return this.http.post<AuthToken>('/api/token/generate-token', login);
  }

  public getAuthorizedUser(): Observable<User> {
    return this.http.get<User>('/api/user/current');
  }
}

export interface AuthToken {
  readonly token: string;
}
