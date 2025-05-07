package com.example.gridview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemData itemData1 = new ItemData(
                List.of(R.drawable.px1,R.drawable.px2),
                "Açıklama metni"
        );

        ItemData itemData2 = new ItemData(
                List.of(R.drawable.px3,R.drawable.px4),
                "Açıklama metni"
        );

        ItemData itemData3 = new ItemData(
                List.of(R.drawable.px5,R.drawable.px6),
                "Açıklama metni"
        );
        List<ItemData> itemDataList = List.of(itemData1, itemData2, itemData3);

        recyclerView.setAdapter(new RecyclerViewAdapter( this,itemDataList));
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private Context context;
        private List<ItemData> dataList; // Verilerimizi burada tutacağız.

        // Constructor
        public RecyclerViewAdapter(Context context, List<ItemData> dataList) {
            this.context = context;
            this.dataList = dataList;
        }

        // ViewHolder oluşturuluyor
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // satir.xml dosyasını inflate ediyoruz
            View view = LayoutInflater.from(context).inflate(R.layout.satir, parent, false);
            return new ViewHolder(view);
        }

        // Verileri bağlama işlemi
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ItemData itemData = dataList.get(position);

            // ImageSlider için veri doldurma
            List<SlideModel> slideModels = new ArrayList<>();
            for (Integer imageUrl : itemData.getImageUrls()) {
                slideModels.add(new SlideModel(imageUrl, null));
            }
            holder.imageSlider.setImageList(slideModels);

            // Butonlar için click listener
            holder.videoButton.setOnClickListener(v -> {
                Toast.makeText(context, "Video Button clicked for item: " + position, Toast.LENGTH_SHORT).show();
            });
            holder.detailButton.setOnClickListener(v -> {
                Toast.makeText(context, "Detail Button clicked for item: " + position, Toast.LENGTH_SHORT).show();
            });
            holder.kubButton.setOnClickListener(v -> {
                Toast.makeText(context, "KUB Button clicked for item: " + position, Toast.LENGTH_SHORT).show();
            });

            // Açıklama metni doldurma
            holder.aciklamaText.setText(itemData.getDescription());
        }

        // Liste eleman sayısını döndürür
        @Override
        public int getItemCount() {
            return dataList.size();
        }

        // ViewHolder sınıfı
        public static class ViewHolder extends RecyclerView.ViewHolder {
            ImageSlider imageSlider;
            Button videoButton, detailButton, kubButton;
            TextView aciklamaText;

            public ViewHolder(View itemView) {
                super(itemView);
                // satir.xml'deki bileşenleri bağlama
                imageSlider = itemView.findViewById(R.id.imageSlider);
                videoButton = itemView.findViewById(R.id.VideoButton);
                detailButton = itemView.findViewById(R.id.DetayButton);
                kubButton = itemView.findViewById(R.id.KUBButton);
                aciklamaText = itemView.findViewById(R.id.text1); // TextView ID'si değişebilir
            }
        }
    }

}
