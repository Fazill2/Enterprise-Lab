import logo from './logo.svg';
import './App.css';
import ProductList from "./ProductList";
import {useEffect, useState} from "react";
import axios from "axios";
import {BrowserRouter, createBrowserRouter, Route, RouterProvider, Routes} from "react-router-dom";
import ProductDetails from "./ProductDetails";
import {ProductsContext} from "./ProductsContext";

function App() {
    const [products, setProducts] = useState([])
    useEffect(() => {
        axios({
            method: 'get',
            url: 'https://dummyjson.com/products',
            responseType: 'json'
        }).then(response => {setProducts(response.data.products)})
    }, [])
    const router = createBrowserRouter([
        {
            path: "/",
            element: <ProductList />,
        },
        {
            path: "details/:id",
            element: <ProductDetails/>,
        }
    ]);
  return (
      <ProductsContext.Provider value={products}>
        <RouterProvider router={router} />
      </ProductsContext.Provider>
  );
}


export default App;
