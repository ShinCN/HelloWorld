package com.example.mycontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mycontact.adapt.ProductAdapter;
import com.example.mycontact.adapt.UserAdapter;
import com.example.mycontact.model.Product;
import com.example.mycontact.model.User;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<User> users;
    ArrayList<Product> products;
    private EditText edtTen, edtCode, edtDesc, edtGia;
    private TextView txt_id, txt_title;
    MyDataBase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        myDatabase = new MyDataBase(this);
//         Initialize contacts

        products = myDatabase.getProducts();
        // Create adapter passing in the sample user data
        ProductAdapter adapter = new ProductAdapter(products);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
        txt_id = (TextView) findViewById(R.id.display_maSP);
//        UserAdapter uAdapter = new UserAdapter(users);
//        final String BASE_URL = "https://jsonplaceholder.typicode.com/";
//
//        Retrofit retrofit = new Retrofit.Builder() .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()) .build();
//
//        OnApiRequest myRetrofitAPI = retrofit.create(OnApiRequest.class);
//
//        myRetrofitAPI.getUser().enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                users = response.body();
//                String content ="";
//                for(User user: users){
//                    content += user.getTitle() + "\n";
//
//                    txt_id.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//
//            }
//        });
//
//        rvContacts.setAdapter(uAdapter);
//        rvContacts.setLayoutManager(new LinearLayoutManager(this));



        edtTen = (EditText) findViewById(R.id.edit_tenSP);
        edtCode = (EditText) findViewById(R.id.edit_MaSP);
        edtDesc= (EditText) findViewById(R.id.edit_mota);
        edtGia = (EditText) findViewById(R.id.edit_price);

        Button btnAddProduct = findViewById(R.id.btn_addPro);
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                products.add(new Product(edtTen.getText().toString(),
                        edtCode.getText().toString(),
                        edtDesc.getText().toString(),
                        Double.parseDouble(String.valueOf(edtGia.getText()))));
                adapter.notifyDataSetChanged();
                rvContacts.scrollToPosition(products.size() - 1);
                myDatabase.insertData(edtTen.getText().toString(), edtCode.getText().toString(), edtDesc.getText().toString(), edtGia.getText().toString());
                edtTen.setText("");
                edtCode.setText("");
                edtDesc.setText("");
                edtGia.setText("");
            }
        });
    }
}