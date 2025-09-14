import { HttpClient } from '@angular/common/http';
import { inject, Inject, Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';

export interface Product {
  _id: string;
  name: string;
  description: string;
  prince: number;
  category: string;
  image: string;
  active: boolean;
}

type ProductsResponse = {page: number, per_page: number, total:number, 
                          total_pages:number, results: Product[] };

@Injectable({
  providedIn: 'root'
})
export class Products {
  httpClient= inject(HttpClient);

  getAll(): Promise<ProductsResponse> {
    return firstValueFrom(
      this.httpClient.get<ProductsResponse>('https://peticiones.online/api/products')
    )
  }
}
