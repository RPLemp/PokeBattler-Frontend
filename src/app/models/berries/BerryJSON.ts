import NamedAPIResource from '../common/NamedAPIResource';

export interface BerryFlavorMap {
  potency: number;
  flavor: NamedAPIResource;
}

interface BerryJSON {
  id: number;
  name: string;
  growth_time: number;
  max_harvest: number;
  natural_gift_power: number;
  size: number;
  smoothness: number;
  soil_dryness: number;
  firmness: NamedAPIResource;
  flavors: BerryFlavorMap[];
  item: NamedAPIResource;
  natural_gift_type: NamedAPIResource;
}

export default BerryJSON;
