package com.bimm.takehomeassignmnent.data

import com.bimm.takehomeassignmnent.domain.interfaces.service.SakeShopService
import com.bimm.takehomeassignmnent.domain.model.Shop
import kotlinx.serialization.json.Json

class SakeShopServiceImpl: SakeShopService {

    val jsonString = "[\n" +
            "    {\n" +
            "        \"name\": \"信州スシサカバ 寿しなの\",\n" +
            "        \"description\": \"Sushi bar with a variety of sake options.\",\n" +
            "        \"picture\": \"http://ts1.mm.bing.net/th?id=OIP.GURnZicaENMLYBMZN9k1LwHaFS&pid=15.1\",\n" +
            "        \"rating\": 4.0,\n" +
            "        \"address\": \"〒380-0824 長野県長野市南長野南石堂町1421\",\n" +
            "        \"coordinates\": [36.644257, 138.18668],\n" +
            "        \"google_maps_link\": \"https://maps.app.goo.gl/4fYMDSfNd6ocsDwt6\",\n" +
            "        \"website\": \"https://www.sushinano.com/\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"長野県酒類販売(株)\",\n" +
            "        \"description\": \"Wholesale sake distributor.\",\n" +
            "        \"picture\": \"https://www.nagano-sake.com/common/images/front/drinks-xxl@2x.jpg\",\n" +
            "        \"rating\": 4.2,\n" +
            "        \"address\": \"〒380-0835 長野県長野市新田町1464\",\n" +
            "        \"coordinates\": [36.629883, 138.21141],\n" +
            "        \"google_maps_link\": \"https://maps.app.goo.gl/wRD6LRQc7Ct9QXMG8\",\n" +
            "        \"website\": \"http://www.nagano-sake.com/\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Kadode\",\n" +
            "        \"description\": \"Japanese restaurant with high-quality sake.\",\n" +
            "        \"picture\": \"https://rimage.hitosara.com/gg/image/0004030762/0004030762I1_1024x767y.webp\",\n" +
            "        \"rating\": 4.4,\n" +
            "        \"address\": \"〒380-0824 長野県長野市南長野南石堂町1421\",\n" +
            "        \"coordinates\": [36.648273, 138.18724],\n" +
            "        \"google_maps_link\": \"https://maps.app.goo.gl/4z71FzXNYYM5oT2GA\",\n" +
            "        \"website\": \"https://hitosara.com/0004030762/\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Midori Nagano\",\n" +
            "        \"description\": \"Shopping center with a variety of sake shops.\",\n" +
            "        \"picture\": null,\n" +
            "        \"rating\": 4.0,\n" +
            "        \"address\": \"〒380-0824 長野県長野市南長野南石堂町1421\",\n" +
            "        \"coordinates\": [36.64396, 138.18893],\n" +
            "        \"google_maps_link\": \"https://maps.app.goo.gl/yPqYieSzdpkyCSd98\",\n" +
            "        \"website\": \"https://www.eki-midori.com/nagano/\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Endo Brewery\",\n" +
            "        \"description\": \"Historic brewery known for its Keiryu brand sake.\",\n" +
            "        \"picture\": \"https://www.keiryu.jp/img_201904/head_parts/shop_img.png\",\n" +
            "        \"rating\": 4.5,\n" +
            "        \"address\": \"〒382-0086 長野県須坂市大字須坂29\",\n" +
            "        \"coordinates\": [36.648273, 138.18724],\n" +
            "        \"google_maps_link\": \"https://maps.app.goo.gl/f288RPXsgHRch3297\",\n" +
            "        \"website\": \"https://www.keiryu.jp/\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Masuichi Brewery\",\n" +
            "        \"description\": \"Brewery located in Obuse, known for its traditional sake.\",\n" +
            "        \"picture\": \"https://gigaplus.makeshop.jp/masuichi/assets_v2/img/common/slide1.jpg\",\n" +
            "        \"rating\": 4.3,\n" +
            "        \"address\": \"〒381-0201 長野県上高井郡小布施町大字小布施807\",\n" +
            "        \"coordinates\": [36.648273, 138.18724],\n" +
            "        \"google_maps_link\": \"https://maps.app.goo.gl/qrZekaJq8qP3yMiy7\",\n" +
            "        \"website\": \"https://www.masuichi.com/\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Miyasaka Brewery\",\n" +
            "        \"description\": \"Brewery in Suwa City, offering a variety of sake.\",\n" +
            "        \"picture\": \"https://www.masumi.co.jp/en/wp/wp-content/uploads/2025/02/top_1.jpg\",\n" +
            "        \"rating\": 4.2,\n" +
            "        \"address\": \"〒392-0004 長野県諏訪市諏訪2丁目9-25\",\n" +
            "        \"coordinates\": [36.648273, 138.18724],\n" +
            "        \"google_maps_link\": \"https://maps.app.goo.gl/wJTiquoJ4Qj8xsUp6\",\n" +
            "        \"website\": \"http://www.masumi.co.jp/\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Tamamura Honten\",\n" +
            "        \"description\": \"Brewery in Yamanouchi, known for its sake and beer.\",\n" +
            "        \"picture\": \"https://img07.shop-pro.jp/PA01336/957/slideshow/slideshow_img1.jpg?cmsp_timestamp=20160118182621\",\n" +
            "        \"rating\": 4.6,\n" +
            "        \"address\": \"〒381-0401 長野県下高井郡山ノ内町大字平穏1163\",\n" +
            "        \"coordinates\": [36.648273, 138.18724],\n" +
            "        \"google_maps_link\": \"https://maps.app.goo.gl/htbv7LKDc9N3aHZ9A\",\n" +
            "        \"website\": \"http://www.tamamura-honten.co.jp/\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Shinshu Kuraudo\",\n" +
            "        \"description\": \"Specialty shop offering sake from around Nagano.\",\n" +
            "        \"picture\": \"https://www.nagano-wine.jp/store/.assets/_DSC6668.jpg\",\n" +
            "        \"rating\": 4.1,\n" +
            "        \"address\": \"〒380-0824 長野県長野市南長野南石堂町1421\",\n" +
            "        \"coordinates\": [36.648273, 138.18724],\n" +
            "        \"google_maps_link\": \"https://maps.app.goo.gl/SuUjW4R3wzuj3YVWA\",\n" +
            "        \"website\": \"https://www.nagano-wine.jp/store/pickup/post-34/\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Hokuan Brewery\",\n" +
            "        \"description\": \"Small brewery in Omachi City, known for its Daikokumasamune sake.\",\n" +
            "        \"picture\": \"https://hokuan.co.jp/wp/wp-content/themes/hokuan/img/bg01.jpg\",\n" +
            "        \"rating\": 4.0,\n" +
            "        \"address\": \"〒398-0002 長野県大町市大町2340-1\",\n" +
            "        \"coordinates\": [36.648273, 138.18724],\n" +
            "        \"google_maps_link\": \"https://maps.app.goo.gl/GQrMNVo6YoVEvCPU6\",\n" +
            "        \"website\": \"https://hokuan.co.jp/\"\n" +
            "    }\n" +
            "]\n"

    override suspend fun getShopList(): ArrayList<Shop> {

        return Json.decodeFromString(jsonString)
    }

}