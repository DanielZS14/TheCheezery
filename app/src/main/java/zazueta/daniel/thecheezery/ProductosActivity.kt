package zazueta.daniel.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductosActivity : AppCompatActivity() {
    var productos = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        val bundle = intent.extras
        var grupo:String = bundle?.get("grupo").toString()

        agregaProductos(grupo)
        var listview: ListView = findViewById(R.id.listView) as ListView
        var adaptador: AdaptadorProductos = AdaptadorProductos(this, productos)
        listview.adapter = adaptador



    }

    fun agregaProductos(grupo_menu:String){

        when(grupo_menu){
            "cold_drinks" -> agregarColdDrinks()
            "hot_drinks" -> agregarHotDrinks()
            "sweets" -> agregarSweets()
            "salties" -> agregarSalties()
            else -> return
        }

    }

    fun agregarColdDrinks(){
        var imagen_menu = findViewById(R.id.imagen_menu) as ImageView
        imagen_menu.setImageResource(R.drawable.colddrinks)
        productos.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
        productos.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
        productos.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
        productos.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
        productos.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
        productos.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))
    }

    fun agregarHotDrinks(){
        var imagen_menu = findViewById(R.id.imagen_menu) as ImageView
        imagen_menu.setImageResource(R.drawable.hotdrinks)
        productos.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0))
        productos.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.0))
        productos.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0))
        productos.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0))
        productos.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0))
        productos.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.0))

    }

    fun agregarSweets(){
        var imagen_menu = findViewById(R.id.imagen_menu) as ImageView
        imagen_menu.setImageResource(R.drawable.sweets)
        productos.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.0))
        productos.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.0))
        productos.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.0))
        productos.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.0))
        productos.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0))
        productos.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0))

    }

    fun agregarSalties(){
        var imagen_menu = findViewById(R.id.imagen_menu) as ImageView
        imagen_menu.setImageResource(R.drawable.salties)
        productos.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0))
        productos.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.0))
        productos.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4.0))
        productos.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
        productos.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.0))
    }



    private class AdaptadorProductos: BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>){
            this.productos = productos
            this.contexto =contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById<ImageView>(R.id.producto_img)
            var nombre = vista.findViewById<TextView>(R.id.producto_nombre)
            var desc = vista.findViewById<TextView>(R.id.producto_desc)
            var precio = vista.findViewById<TextView>(R.id.producto_precio)

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")

            return vista
        }

    }
}