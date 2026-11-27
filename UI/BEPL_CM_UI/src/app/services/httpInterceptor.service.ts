import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { NotificationService } from "./notification.service";

@Injectable()
export class httpInterceptor implements HttpInterceptor {

  constructor(private notify: NotificationService,) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) => {

        // if (error.status === 402) {
        //   this.notify.showError(error.error);
        // }
        return throwError(error);
      })
    );
  }
}
