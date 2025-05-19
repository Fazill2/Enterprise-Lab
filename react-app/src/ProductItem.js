
function ProductItem({title, brand, id}) {
    return (
        <li> <a href={'details/' + id   }>{title}</a> ({brand})</li>
    );
}

export default ProductItem;
