import {useParams} from "react-router-dom";
import {useProducts} from "./ProductsContext";

function ProductDetails() {
    const products = useProducts();
    const params = useParams()
    const id = params.id;
    console.log(id);
    const products_filtered = products.filter((item) => item.id == id)
    console.log(products)
    if (products_filtered.length === 0) {
        return null;
    }

    const product = products_filtered[0];

    return (
        <div>
            <h1>{product.title}</h1>
            {product.category} <br></br>
            {product.brand} <br></br>
            {product.description} <br></br>
            {product.price} <br></br>
            <img src={product.thumbnail} alt={product.name} />
            <a href={`/`}>Go back</a>
        </div>
    );
}

export default ProductDetails;
