import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, Subject, BehaviorSubject, throwError } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    "Content-Type": "application/json"

  })
};
@Injectable({
  providedIn: "root"
})
export class HttpService {
  private subject = new BehaviorSubject<boolean>(true);
  isLoginPage = this.subject.asObservable();
  constructor(private httpclient: HttpClient) {}

  httpGetService(payload): Observable<any> {
    return this.httpclient.get(payload);
  }
  httpPostService(url, body): Observable<any> {
    return this.httpclient.post(url, body, httpOptions);
  }
  httpPostServiceWithoutBody(url): Observable<any> {
    return this.httpclient.post(url,  httpOptions);
  }
  httpPutService(url, body): Observable<any> {
    return this.httpclient.put(url, body);
  }
  httpDeleteService(payload): Observable<any> {
    return this.httpclient.delete(payload);
  }
  httpFileUploadService(url, body): Observable<any> {
    const httpUploadOptions = {
      headers: new HttpHeaders({ Accept: "application/json" })
    };
    return this.httpclient.post(url, body, httpUploadOptions);
  }
}
