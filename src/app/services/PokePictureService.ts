import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class PokePictureService {
	private readonly baseUrl: string = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";
	private readonly client: HttpClient = inject(HttpClient);

	public getPictureBackShiny(id: number): Observable<Blob> {
		return this.getPicture(`back/shiny/${id}.png`)
	}

	public getPictureBackFemale(id: number): Observable<Blob> {
		return this.getPicture(`back/${id}.png`)
	}

	public getPictureFrontShiny(id: number): Observable<Blob> {
		return this.getPicture(`shiny/${id}.png`)
	}

	public getPictureBackDefault(id: number): Observable<Blob> {
		return this.getPicture(`back/${id}.png`)
	}

	public getPictureFrontFemale(id: number): Observable<Blob> {
		return this.getPicture(`${id}.png`)
	}

	public getPictureFrontDefault(id: number): Observable<Blob> {
		return this.getPicture(`${id}.png`)
	}

	public getPictureBackShinyFemale(id: number): Observable<Blob> {
		return this.getPicture(`back/shiny/${id}.png`)
	}

	public getPictureFrontShinyFemale(id: number): Observable<Blob> {
		return this.getPicture(`shiny/${id}.png`)
	}

	public getPicture(url: string): Observable<Blob> {
		return this.client.get(`${this.baseUrl}/${url}`, {
			responseType: 'blob'
		});
	}

	public downloadBlob(blob: Blob, filename: string): void {
		const objectUrl = URL.createObjectURL(blob);
		const anchor = document.createElement('a');
		anchor.href = objectUrl;
		anchor.download = filename;
		document.body.appendChild(anchor);
		anchor.click();
		anchor.remove();
		URL.revokeObjectURL(objectUrl);
	}
}
