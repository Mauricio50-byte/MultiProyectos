import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonicModule} from '@ionic/angular';
import { Product, Products } from '../services/products.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.page.html',
  styleUrls: ['./product-list.page.scss'],
  standalone: true,
  imports: [IonicModule, CommonModule, FormsModule]
})
export class ProductListPage implements OnInit {

  products: Product[] = [];
  productsService = inject(Products);
  async ngOnInit() {
    const response = await this.productsService.getAll();
    this.products = response.results;
  }

}
