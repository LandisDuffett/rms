import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditHttpBookComponent } from './edit-http-book.component';

describe('EditHttpBookComponent', () => {
  let component: EditHttpBookComponent;
  let fixture: ComponentFixture<EditHttpBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditHttpBookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditHttpBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
