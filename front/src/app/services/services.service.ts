import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Service} from '../modules/models/service';

@Injectable()
export class ServicesService {

  constructor(private http: HttpClient) {
  }

  getServices(): Observable<Service[]> {
    return this.http.get<Service[]>('/api/service');
  }

  createService(service: Service): Observable<void> {
    return this.http.post<void>('/api/service', service);
  }

  deleteService(serviceId: number): Observable<void> {
    return this.http.delete<void>('/api/service/' + serviceId);
  }
}
