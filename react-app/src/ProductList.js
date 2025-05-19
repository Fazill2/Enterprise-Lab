import {useEffect, useState} from 'react';
import ProductItem from "./ProductItem";
import axios from "axios";
import {useProducts} from "./ProductsContext";

function ProductList() {
    const [filter, setFilter] = useState("")
    const products = useProducts();
    return (
        <div>
            <h1>List of products</h1>
            <span>Filter by Product tile: </span>
            <input id={'filter'} onChange={(e) => setFilter(e.target.value)} />
            <ul style={{ textAlign: "left" }}>
                {products.filter(product=>product.title.indexOf(filter) !== -1).map(product => (<ProductItem key={product.id} title={product.title} brand={product.brand} id={product.id} />))}
            </ul>
        </div>
    );
}

export default ProductList;
