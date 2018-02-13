/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package ua.com.kl.yuri.justjava;
 *
 */
package ua.com.kl.yuri.justjava;

import android.content.Intent;
import android.net.Uri;
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
    String orderSummaryName = "No name";
    private String getSummaryName(){
        EditText strName = (EditText) findViewById(R.id.input_name);

        if (strName.getText().length() == 0) {
            orderSummaryName = "No name";
        } else {
            Editable getOrderSummaryName = strName.getText();
            orderSummaryName = getOrderSummaryName.toString();
        }

        return orderSummaryName;
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
                getString(R.string.toast_modal_max), Toast.LENGTH_SHORT);

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
                getString(R.string.toast_modal_min), Toast.LENGTH_SHORT);

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
        priceView.setText(" " + (number * 5));
    }


    /**
     * This method is called when the order button is clicked.
     */
    /**
     * variable int for counter method submitOrder
     */
    /**
     * getString(R.string.name attr for text)*/

    public void submitOrder(View view) {
        String infoSummary = submitOrderSummary();
        String priceMessage = infoSummary + getString(R.string.total_m) + (quantity * 5 + selectWhippedCream + selectChocolate);
        String textMessage = priceMessage + "\n" + getString(R.string.thank_you) + "\n";
//
//        displayMessage(textMessage);

        /** Intent Email **/
        Intent intent = new Intent();

        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_EMAIL, "wimg.markup@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.theme_mail));
        intent.putExtra(Intent.EXTRA_TEXT, textMessage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method is name and quality
     */
    private String submitOrderSummary() {
        String name = getSummaryName();
        String info = getString(R.string.order_summary_name, name) +
                "\n" + getString(R.string.added_whipped_cream) + " " + hasWhippedCream +
                "\n" + getString(R.string.added_chocolate) + " " + hasChoco +
                "\n" + getString(R.string.quantity) + " " + quantity +
                "\n";

        return info;
    }

    /**
     * This method displays the given quantity value on the screen.
     * */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//    }
}