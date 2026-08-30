import NamedAPIResource from './NamedAPIResource';

interface VerboseEffect {
  effect: string;
  short_effect?: string;
  shortEffect?: string;
  language: NamedAPIResource;
}

export default VerboseEffect;
