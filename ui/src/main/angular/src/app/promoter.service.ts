import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Challenge } from './challenge';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PromoterService {
  private promoterUrl = '/promoter/promoteFight';  // URL to web api

  constructor(private http: HttpClient) {
  }

  public promoteFight(challenge: Challenge): Observable<string> {
    return this.http.post<string>(this.promoterUrl, {
      challenger: challenge.challenger,
      challengee: challenge.challengee
    }, {
      responseType: 'text' as 'json'
    });
  }
}
