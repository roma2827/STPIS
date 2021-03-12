import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TooltipModule } from "ngx-bootstrap/tooltip";
import { ModalModule } from "ngx-bootstrap/modal";
import { FormsModule } from "@angular/forms";
import { AppComponent } from "./app.component";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import {HeaderModule} from "./modules/header/header.module";
import {HomeComponent} from "./modules/home/home.component";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {UserService} from "./services/user.service";
import {APIInterceptor} from "./interceptors/api-interceptor";
import {STPISModule} from "./modules/STPIS.module";
import {ServicesComponent} from "./modules/services/services.component";


const appRoutes: Routes = [
  { path: "", component: HomeComponent},
  { path: "services", component: ServicesComponent}
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
