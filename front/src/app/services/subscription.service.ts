import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Subscriptions} from '../modules/models/subscriptions';

@Injectable()
export class SubscriptionService {

  constructor(private http: HttpClient) {
  }

  subscribe(subscriptions: Subscriptions): Observable<void> {
    return this.http.post<void>('/api/service', subscriptions);
  }
}
