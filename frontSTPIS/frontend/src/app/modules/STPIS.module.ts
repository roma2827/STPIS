import {HomeComponent} from './home/home.component';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';
import {StorageService} from '../services/storage.service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ServicesComponent} from './services/services.component';
import {UserService} from '../services/user.service';
import {ServicesService} from '../services/services.service';
import {SubscriptionService} from '../services/subscription.service';


@NgModule({
  declarations: [
    HomeComponent,
    ServicesComponent
  ],
  imports: [
    // UserAccountModule,
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    NgbModule,
    ReactiveFormsModule
  ],

  providers: [StorageService, UserService, ServicesService, SubscriptionService],
  exports: [HomeComponent, ServicesComponent],
  bootstrap: [HomeComponent]
})
export class STPISModule {
}
