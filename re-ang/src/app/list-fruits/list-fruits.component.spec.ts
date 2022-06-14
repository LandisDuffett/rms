import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListFruitsComponent } from './list-fruits.component';

describe('ListFruitsComponent', () => {
  let component: ListFruitsComponent;
  let fixture: ComponentFixture<ListFruitsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListFruitsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListFruitsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
