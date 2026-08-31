import PokemonJSON from './PokemonJSON';

interface Pokemon extends PokemonJSON {
	frontDefault?: Blob;
	frontDefaultUrl?: string;
}

export default Pokemon;
