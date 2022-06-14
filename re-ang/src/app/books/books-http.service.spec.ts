import { TestBed } from '@angular/core/testing';

import { BooksHttpService } from './books-http.service';

describe('BooksHttpService', () => {
  let service: BooksHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BooksHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
