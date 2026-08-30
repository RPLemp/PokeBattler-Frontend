import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PokeOverview } from './poke-overview';

describe('PokeOverview', () => {
  let component: PokeOverview;
  let fixture: ComponentFixture<PokeOverview>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PokeOverview],
    }).compileComponents();

    fixture = TestBed.createComponent(PokeOverview);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
