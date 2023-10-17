import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfesoresIndexComponent } from './profesores-index.component';

describe('ProfesoresIndexComponent', () => {
  let component: ProfesoresIndexComponent;
  let fixture: ComponentFixture<ProfesoresIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfesoresIndexComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfesoresIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
