import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewHttpBooksComponent } from './view-http-books.component';

describe('ViewHttpBooksComponent', () => {
  let component: ViewHttpBooksComponent;
  let fixture: ComponentFixture<ViewHttpBooksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewHttpBooksComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewHttpBooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
