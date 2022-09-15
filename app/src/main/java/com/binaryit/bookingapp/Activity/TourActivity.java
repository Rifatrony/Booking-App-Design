package com.binaryit.bookingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.binaryit.bookingapp.Adapter.TourAdapter;
import com.binaryit.bookingapp.Model.TourModel;
import com.binaryit.bookingapp.R;

import java.util.ArrayList;
import java.util.List;

public class TourActivity extends AppCompatActivity {

    RecyclerView tourRecyclerView;
    List<TourModel> tourModelList;
    TourAdapter tourAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);


        initialization();

    }

    private void initialization() {
        tourRecyclerView = findViewById(R.id.tourRecyclerView);
        tourRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tourRecyclerView.setHasFixedSize(true);

        tourModelList = new ArrayList<>();
        tourModelList.add(new TourModel("Debotakhum Day Trip", "Debotakhum", "1 Day & 1 Night", "standard",
                "","09/15/2022",
                "All meals (Breakfast , Lunch, Dinner), Non - AC Bus service", "Boat Service For Roaming, No Medicines",
                "রুটি/পরোটা + সবজি/ডাল হাঁস/ মুরগী + ভাত +চিকেন ঝাল ফ্রাই /গরু" ,"রাত ১১ টার বাসে বান্দরবান রওনা ",
                "01628979644", 3200, 40 ,R.drawable.debotakhum));

        tourModelList.add(new TourModel("Lama-Alikadam Premium Package", "Ali's Cave,Dim Pahar,Matamuhuri River,Maya Lake", "2 Day & 3 Night", "standard",
                "যেসব প্লেস ঘুরবোঃ \n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "১. লামা বাজার\n" +
                        "\n" +
                        "২. মাতামুহুরি নদী + বোট রাইড \n" +
                        "\n" +
                        "৩. শৈলকুঠি ইকো রিসোর্ট \n" +
                        "\n" +
                        "৪. আলীর গুহা \n" +
                        "\n" +
                        "৫. ডিম পাহাড় \n" +
                        "\n" +
                        "৬. মায়ালেক\n" +
                        "\n" +
                        "৭. থানচি - আলীকদম সড়ক( বাংলাদেশের সবচেয়ে উঁচু রাস্তা) ","09/15/2022",
                "All meals (Breakfast , Lunch, Dinner), Non - AC Bus service", "Boat Service For Roaming, No Medicines",
                "রুটি/পরোটা + সবজি/ডাল হাঁস/ মুরগী + ভাত +চিকেন ঝাল ফ্রাই /গরু" ,"রাত ১১ টার বাসে বান্দরবান রওনা ",
                "01628979644", 5500, 20 ,R.drawable.lama));

        tourModelList.add(new TourModel("St. Martin Regular trip", " Chera Dwip,St. Martin's Island", "3 Day & 4 Night", "standard",
                "It is a St. Martin Relax trip","09/15/2022",
                "১. ঢাকা থেকে টেকনাফ non এসি বাসে যাওয়া - আসা \n" +
                        "\n" +
                        "২. ছেঁড়া দীপ যাওয়ার ট্রলার ভাড়া ।\n" +
                        "\n" +
                        "৩. ৩দিনের ৮ বেলা খাবার( শেষ রাতের খাবার ছাড়া)\n" +
                        "\n" +
                        "৪. কটেজ খরচ(শেয়ার ব্যাসিসে থাকা)", "Boat Service For Roaming, No Medicines",
                "রুটি/পরোটা + সবজি/ডাল হাঁস/ মুরগী + ভাত +চিকেন ঝাল ফ্রাই /গরু" ,"ডে ০ : সন্ধ্যা ৬.৩০ এর বাসে ঢাকা থেকে রওয়ানা হবো টেকনাফের উদ্দেশ্যে।\n" +
                "\n" +
                "ডে ১ : সকালে গিয়ে নামবো টেকনাফ ঘাটে। তারপর সেখানকার স্থানীয় রেষ্টুরেন্টে আমরা সবাই ফ্রেশ \n" +
                "\n" +
                "       হয়ে নাস্তা করে শিপে রওয়ানা হবো সেন্টমার্টিনের উদ্দেশ্যে। গাংচিলদের মেলা দেখতে দেখতে \n" +
                "\n" +
                "       পৌছে যাবো সেন্টমার্টিনে। গিয়ে হোটেলে চেক ইন করে বীচের নীল পানিতে ঝাপ। এরপর ফ্রেশ \n" +
                "\n" +
                "       হয়ে লাঞ্চ। বিকেলে ঘুরবো কোরাল বীচ এবং দেখব সূর্যাস্ত। রাতে ডিনার করে সমুদ্রের গর্জন\n" +
                "\n" +
                "        শুনবো।",
                "01628979644", 3200, 40 ,R.drawable.saintmartin));



        tourAdapter = new TourAdapter(this, tourModelList);
        tourRecyclerView.setAdapter(tourAdapter);





    }
}