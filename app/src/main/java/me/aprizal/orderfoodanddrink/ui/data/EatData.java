package me.aprizal.orderfoodanddrink.ui.data;

import java.util.ArrayList;

import me.aprizal.orderfoodanddrink.R;
import me.aprizal.orderfoodanddrink.ui.model.EatModel;

public class EatData {
    private static final int[] img_list_eat = {
            R.raw.brokoli,
            R.raw.gado_gado,
            R.raw.ikan_salmon,
            R.raw.oatmeal,
            R.raw.pepes_ikan,
            R.raw.roti_bakar_alpukat,
            R.raw.sandwich,
            R.raw.sop_bening,
            R.raw.steak_salad,
            R.raw.telur
    };
    private static final String[] name_list_eat = {
            "Brokoli",
            "Gado-Gado",
            "Ikan Salmon",
            "Oatmel",
            "Pepes Ikan",
            "Roti Bakar Alpukat",
            "Sandwich",
            "Sop Bening",
            "Steak Salad",
            "Telur"
    };
    private static final String[] price_list_eat = {
            "10.000",
            "15.000",
            "12.000",
            "10.000",
            "15.000",
            "10.000",
            "17.000",
            "14.000",
            "18.000",
            "10.000"
    };
    private static final String[] detail_list_eat = {
            "Sayur brokoli juga menjadi salah satu jenis sayuran yang rasanya tidak pahit. Selain itu, brokoli juga mengandung kalori yang rendah. Brokoli dapat diolah menjadi beragam jenis sayuran, semisal tumis brokoli atau dicampur dengan sayur lain menjadi capcai. Banyak manfaat yang bisa kamu dapat dari mengonsumsi brokoli yang kaya antioksidan ini, misalnya mencegah penyakit kanker, jantung, dan alzheimer",
            "Nah, kalau menu makanan sehat satu ini bisa dibilang sebagai saladnya Indonesia. Cara membuatnya pun cukup mudah, kamu cukup mencampur beberapa jenis sayur, semisal tauge, wortel, kubis, mentimun, tempe, dan lain-lain. Lalu, guyurlah campuran sayur tersebu menggunakan bumbu kacang.segar, tetapi juga mengandung banyak gizi di dalamnya.",
            "Ikan salmon menjadi salah satu menu makanan diet sehat yang harus kamu coba. Olahan ikan salmon mengandung protein, vitamin B, lemak sehat, kalium, dan selenium yang bermanfaat untuk kesehatan tubuh. Selain menurunkan berat badan, mengonsumsi ikan salmon secara teratur dapat menurunkan risiko sakit jantung dan diabetes.",
            "Oatmeal adalah salah satu makanan superfood yang biasa disantap ketika sarapan. Kandungan serat yang tinggi dalam oatmeal sangat baik untuk sistem pencernaan. Makanan ini juga bisa membuat kamu merasa kenyang lebih lama, sehingga konsumsi makanan sepanjang hari dapat lebih terjaga. Sajikan oatmeal dengan susu dan madu untuk menambah rasa manis alami, atau bisa juga diolah menjadi snack seperti granola bar, cookies, dan lain-lain.",
            "Pepes ikan adalah salah satu contoh menu makanan sehat yang menggabungkan gizi dari ikan dan sayur-sayuran. Kandungan asam lemak omega 3 pada ikan dipercaya dapat membantu mencegah penyakit jantung. Santapan ini terasa lebih nikmat jika kita memakannya dengan lalap sayur yang menyegarkan.",
            "Apakah kamu pernah mencoba mencampurkan roti bakar dengan telur dan alpukat? Cobain deh, karena telur dan alpukat yang dilapisi roti bakar bisa jadi alternatif menu makanan diet sehat di pagi hari. Alpukat yang kaya vitamin ditambah protein dalam telur dapat membuat kamu lebih bugar dalam menjalani aktivitas sehari-hari.",
            "Sama halnya dengan roti bakar, sandwich juga menjadi menu sarapan sehat. Tentu sangat nikmat menyantap selada, mentimun, tomat, keju, dan daging di dalam dua lapis roti sebelum berangkat kerja. Kandungan antioksidan pada sayur dan protein pada daging dapat menjadi sumber energi kamu menjalani rutinitas.",
            "Satu lagi menu campuran sayuran yang menyehatkan tubuh adalah sop bening. Makanan ini tentu sangat nikmat dikonsumi pada malam hari yang dingin. Sayuran dalam sop dapat membantu tubuh kamu lebih bugar dan sehat. Selain itu, jangan lupakan kandungan protein dalam daging di sop tersebut yang bisa membuat kamu meningkatkan kekebalan tubuh.",
            "Steak salad adalah menu sehat sehari yang mirip dengan salad. Perbedaannya, salah satu ini ditambah dengan sajian daging steak. Karena ada bahan yang ditambah, maka manfaatnya juga bertambah. Kandungan protein dan zat besi dalam daging sapi dapat membantu kamu meningkatkan kekebalan tubuh dan kekuatan otot.",
            "Bahan makanan yang sudah biasa dikonsumsi sehari-hari ini ternyata memiliki banyak nutrisi yang sangat baik untuk tubuh lho, Toppers. Kandungan dalam kuning telur dapat menjaga kesehatan mata dan melindungi kulit dari kerusakan karena terpapar sinar UV. Kamu bisa mengkonsumsi telur dengan cara apapun sesuai dengan selera, tetapi jika ingin benar-benar sehat, disarankan untuk menyajikan telur rebus atau kukus."
    };
    public static ArrayList<EatModel> getEatModelArrayList(){
        ArrayList<EatModel> eatModelArrayList = new ArrayList<>();
        for (int position = 0; position < name_list_eat.length; position++){
            EatModel eatModel = new EatModel();
            eatModel.setImg_eat(img_list_eat[position]);
            eatModel.setName_eat(name_list_eat[position]);
            eatModel.setPrice_eat(price_list_eat[position]);
            eatModel.setDetail_eat(detail_list_eat[position]);
            eatModelArrayList.add(eatModel);
        }
        return eatModelArrayList;
    }
}
