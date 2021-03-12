import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {APIInterceptor} from './interceptors/api-interceptor';
import {HomeComponent} from "./modules/home/home.component";
import {ServicesComponent} from "./modules/services/services.component";
import {HeaderModule} from "./modules/header/header.module";
import {STPISModule} from "./modules/STPIS.module";
import {UserService} from "./services/user.service";

const appRoutes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'services', component: ServicesComponent}
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    HeaderModule,
    STPISModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    NgbModule
  ],
  providers: [UserService, APIInterceptor, {
    provide: HTTP_INTERCEPTORS,
    useClass: APIInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
