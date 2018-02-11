/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package ua.com.kl.yuri.justjava;
 *
 */
package ua.com.kl.yuri.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    /**
     * This GetName field input
     */
    String clientName = "No name";
    private String getName(){
        EditText strName = (EditText) findViewById(R.id.input_name);

        if (strName.getText().length() == 0) {
            clientName = "No name";
        } else {
            Editable getNameClient = strName.getText();
            clientName = (String) getNameClient.toString();
        }

        return clientName;
    }

    /**
     * This CheckBox cream
     */
    boolean hasWhippedCream;
    int selectWhippedCream = 0;
    public boolean buttonChoiceCream(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_whipped_cream);

        if(checkBox.isChecked()) {

            hasWhippedCream = true;
            selectWhippedCream = 1;
//            Log.v("MainActivity", "checkBox status is " + hasWhippedCream);
            return hasWhippedCream;
        } else {

            hasWhippedCream = false;
            selectWhippedCream = 0;
//            Log.v("MainActivity", "checkBox status is " + hasWhippedCream);
            return hasWhippedCream;
        }
    }

    /**
     * This CheckBox chocolate
     */
    boolean hasChoco;
    int selectChocolate = 0;
    public boolean buttonChoiceChoco(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_chocolate);

        if(checkBox.isChecked()) {

            hasChoco = true;
            selectChocolate = 2;
//            Log.v("MainActivity", "checkBox status is " + hasChoco);
            return hasChoco;
        } else {
//            checkBox.setChecked(false);

            hasChoco = false;
            selectChocolate = 0;
//            Log.v("MainActivity", "checkBox status is " + hasChoco);
            return hasChoco;
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @param --quantity is the number of cups of coffee ordered
     */
    int quantity = 1;
    public void incrementOrder(View view) {
        //modals text
        Toast modalIncrement = Toast.makeText(getApplicationContext(),
                "Нельзя заказать кофе более 15 чашек", Toast.LENGTH_SHORT);

        if (quantity == 15) {
            this.quantity = 15;
            modalIncrement.show();
        } else {
            this.quantity++;
        }

        display(quantity);
        displayPricePreview(quantity);
    }

    public void decrementOrder(View view) {
        //modals text
        Toast modalDecrement = Toast.makeText(getApplicationContext(),
                "Нельзя заказать кофе менее 1 чашки", Toast.LENGTH_SHORT);

        if (quantity == 1) {
            this.quantity = 1;
            modalDecrement.show();
        } else {
            this.quantity--;
        }

        display(quantity);
        displayPricePreview(quantity);
    }

    /**
     * This method is called when the order button is clicked + or -.
     */
    private void displayPricePreview(int number) {
        TextView priceView = (TextView) findViewById(R.id.price_view);
        priceView.setText("" + (number * 5));
    }


    /**
     * This method is called when the order button is clicked.
     */
    /**
     * variable int for counter method submitOrder
     */

    public void submitOrder(View view) {
        String infoSummary = submitOrderSummary();
        String priceMessage = infoSummary + "Total: $" + (quantity * 5 + selectWhippedCream + selectChocolate);
        String textMessage = priceMessage + "\n" + "Thank you!" + "\n";

        displayMessage(textMessage);
    }

    /**
     * This method is name and quality
     */
    private String submitOrderSummary() {
        String info = "Name: " + getName() + "\n" + "Added Whipped Cream " + hasWhippedCream + "\n" + "Added Chocolate " + hasChoco + "\n" + "Quantity: " + quantity + "\n";

        return info;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}