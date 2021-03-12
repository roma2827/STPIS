import {NgModule} from "@angular/core";
import {HeaderComponent} from "./components/header.component";
import {RouterModule} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";
import {StorageService} from "../../services/storage.service";
import {UserService} from "../../services/user.service";


@NgModule({
  declarations: [
    HeaderComponent
  ],
    imports: [
        RouterModule,
        FormsModule,
        BrowserModule,
        ReactiveFormsModule
    ],
  providers: [UserService, StorageService],
  exports: [HeaderComponent]
})
export class HeaderModule {}
