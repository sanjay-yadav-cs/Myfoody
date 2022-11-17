package com.example.myfoody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Food_catlog extends AppCompatActivity {
    RecyclerView recyclerView;
    Menu menu;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_catlog);
        auth=FirebaseAuth.getInstance();

        recyclerView=findViewById(R.id.recyclerview);
        ArrayList<foodModel> list = new ArrayList<>();
//        list.add(new foodModel('https://freepngimg.com/thumb/burger/6-2-burger-png-image.png,"Burger',"ggg");
        list.add(new foodModel("https://d2j6dbq0eux0bg.cloudfront.net/images/39892083/1894967124.jpg","Biryani"));
        list.add(new foodModel("https://freepngimg.com/thumb/burger/6-2-burger-png-image.png","Burger"));
        list.add(new foodModel("https://www.spicyeats.in/images/menu_23.jpg","Icecream"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://freepngimg.com/thumb/cocacola/3-coca-cola-can-png-image.png","Cock"));
        list.add(new foodModel("https://freepngimg.com/thumb/burger/6-2-burger-png-image.png","HotDog"));
        list.add(new foodModel("https://www.spicyeats.in/images/menu_09.jpg","Chanies"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://www.spicyeats.in/images/menu_23.jpg","Icecream"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/2-2-sweets-free-download-png.png","Laddo"));
        list.add(new foodModel("https://www.spicyeats.in/images/menu_15.jpg","Pasta"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/2-2-sweets-free-download-png.png","Laddo"));
        list.add(new foodModel("https://www.spicyeats.in/images/menu_23.jpg","Icecream"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://freepngimg.com/thumb/burger/6-2-burger-png-image.png","HotDog"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://freepngimg.com/thumb/burger/6-2-burger-png-image.png","HotDog"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://freepngimg.com/thumb/burger/6-2-burger-png-image.png","HotDog"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        list.add(new foodModel("https://freepngimg.com/thumb/sweets/1-2-sweets-png-clipart.png","Sweets"));
        foodAdapter adapter= new foodAdapter(list,Food_catlog.this);
        recyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.setting:
                Toast.makeText(Food_catlog.this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                auth.signOut();
                finish();
                Intent intent=new Intent(Food_catlog.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}