import { TestBed } from '@angular/core/testing';

import { PromoterService } from './promoter.service';

describe('PromoterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PromoterService = TestBed.get(PromoterService);
    expect(service).toBeTruthy();
  });
});
