/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */
package com.example.android.just_java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;
import android.content.Intent;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int numberOfCoffee = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayOrder(true);
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void addQuantity(View view) {
        numberOfCoffee++;
        display(numberOfCoffee);
        displayPrice(numberOfCoffee * 5);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void minusQuantity(View view) {
        if (numberOfCoffee > 0) {
            numberOfCoffee--;
        }
        display(numberOfCoffee);
        displayPrice(numberOfCoffee * 5);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays a string when order is submitted.
     */
    private void displayOrder(boolean action) {
        TextView orderTextView = (TextView) findViewById(R.id.order_text_view);
        if (action == true) {
            orderTextView.setText("Your coffee is brewing...");
        } else {
            orderTextView.setText("");
        }
    }
    /**
     * This method displays a string when order is submitted.
     */
    public void resetOrder(View view) {
        numberOfCoffee = 0;
        displayPrice(numberOfCoffee);
        display(numberOfCoffee);
        displayOrder(false);
    }
}
