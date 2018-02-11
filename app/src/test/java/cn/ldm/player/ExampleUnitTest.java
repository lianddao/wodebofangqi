package cn.ldm.player;

import org.junit.Test;

import cn.ldm.player.core.maicong.KuGou;
import cn.ldm.player.core.maicong.RegexMatches;

import static org.junit.Assert.*;

/**
 * 本地单元测试的示例，将在开发机器（宿主）上执行。
 * https://developer.android.com/studio/test/index.html
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getKugou() throws Exception {
        //region js
        String js = "var apmCollectData = apmCollectData || [];\n" +
                "var global = {\n" +
                "\t// 域名\n" +
                "\tkg_domain : \"http://www.kugou.com/yy\",\n" +
                "\tjscssdate: \"201505211743\",\n" +
                "\tpage: '1', // 当期页\n" +
                "\tpagesize: '22', // 页条数\n" +
                "\ttotal: '100' // 总数\n" +
                "};\n" +
                "// 列表数据\n" +
                "global.features = [{\"Hash\":\"4E468808B43D48D8CEACB9C661DB6183\",\"FileName\":\"\\u6c6a\\u82cf\\u6cf7\\u3001\\u9b4f\\u5de1\\u3001YOUNG-G\\u3001SNH48_7SENSES - \\u6b22\\u547c\\u4e2d\\u56fd\\u5e74 (Live)\",\"timeLen\":169.087,\"privilege\":10,\"size\":2718405,\"album_id\":8339042,\"encrypt_id\":\"lz4yx75\"},{\"Hash\":\"61C666B9E8107BB8AC39F488B3D686CB\",\"FileName\":\"\\u534e\\u6668\\u5b87 - \\u5b69\\u5b50 (Live)\",\"timeLen\":321.041,\"privilege\":10,\"size\":5142957,\"album_id\":8345464,\"encrypt_id\":\"lzc3a45\"},{\"Hash\":\"53844E02B687E39880D7043B04A6DA22\",\"FileName\":\"\\u5173\\u6653\\u5f64\\u3001\\u738b\\u5609 - \\u5f1f\\u5b50\\u89c4 (Live)\",\"timeLen\":181.06,\"privilege\":10,\"size\":2906286,\"album_id\":8339042,\"encrypt_id\":\"lz4to1b\"},{\"Hash\":\"89CC709916D7B6C6D180571507B4DDAA\",\"FileName\":\"\\u9ad8\\u5b89\\u3001\\u738b\\u96c5\\u5b81 - \\u4f60\\u662f\\u6211\\u7684\\u4f34\",\"timeLen\":215.025,\"privilege\":10,\"size\":3444579,\"album_id\":8344093,\"encrypt_id\":\"lz3t4c6\"},{\"Hash\":\"912A63E7B7D5579E16E02B1A531FF67E\",\"FileName\":\"\\u5927\\u5f20\\u4f1f - \\u53ea\\u60f3\\u548c\\u4f60\\u9759\\u5ea6\\u65f6\\u5149+\\u70ed\\u8840\\u71c3 (Live)\",\"timeLen\":226.04,\"privilege\":10,\"size\":3623108,\"album_id\":8339042,\"encrypt_id\":\"lz5d2be\"},{\"Hash\":\"FA071FF058AF9E5C41DC67C854B1D497\",\"FileName\":\"\\u6d1b\\u5929\\u4f9d - \\u900f\\u660e\\u7684\\u5e0c\\u5180\",\"timeLen\":218.002,\"privilege\":0,\"size\":3488905,\"album_id\":8344812,\"encrypt_id\":\"lz5ui47\"},{\"Hash\":\"E272D901B625140E990DFE654D81EEE5\",\"FileName\":\"\\u9ec4\\u6653\\u660e\\u3001\\u9773\\u68a6\\u4f73 - \\u5e74\\u591c\\u996d (Live)\",\"timeLen\":182.065,\"privilege\":10,\"size\":2923004,\"album_id\":8339042,\"encrypt_id\":\"lz4s1ce\"},{\"Hash\":\"6D8A17CAC014BE410D2079E46E7FA7B5\",\"FileName\":\"\\u5f20\\u97f6\\u6db5 - \\u6765\\u8fc7\\u6211\\u751f\\u547d\\u7684\\u4f60 (Live)\",\"timeLen\":327.055,\"privilege\":10,\"size\":5241261,\"album_id\":8345464,\"encrypt_id\":\"lzc67a5\"},{\"Hash\":\"8F6A1FD8AEB458397A185C420CDEE9B5\",\"FileName\":\"\\u7f57\\u5927\\u4f51 - \\u604b\\u66f22018 (Live)\",\"timeLen\":333.071,\"privilege\":10,\"size\":5339845,\"album_id\":8339042,\"encrypt_id\":\"lz5fo01\"},{\"Hash\":\"3788A001848EB35C807612326EAF3553\",\"FileName\":\"\\u534e\\u8bed\\u7fa4\\u661f - \\u6c6a\\u6c6a\\u8d3a\\u65b0\\u5e74 (Live)\",\"timeLen\":267.042,\"privilege\":10,\"size\":4279288,\"album_id\":8339042,\"encrypt_id\":\"lz4hl91\"},{\"Hash\":\"71F8A96F5915425E96416CB28FC11CFB\",\"FileName\":\"\\u675c\\u6d77\\u6d9b\\u3001\\u6c88\\u68a6\\u8fb0\\u3001\\u738b\\u4e00\\u535a\\u3001\\u9a6c\\u601d\\u8d85\\u3001\\u5218\\u627f\\u6797\\u3001\\u84dd\\u535a\\u3001\\u674e\\u6d69\\u83f2 - \\u65b0\\u6625\\u65fa18 (Live)\",\"timeLen\":212.032,\"privilege\":10,\"size\":3397812,\"album_id\":8339042,\"encrypt_id\":\"lz4s049\"},{\"Hash\":\"0DBC1E271612559994F48E779A71671E\",\"FileName\":\"Jessie J - Ain't Nobody (Live)\",\"timeLen\":316.025,\"privilege\":10,\"size\":5060397,\"album_id\":8345464,\"encrypt_id\":\"lzc2w32\"},{\"Hash\":\"554C7CCEA26B55007576CAF8F828A6B0\",\"FileName\":\"\\u5f20\\u78a7\\u6668\\u3001\\u817e\\u683c\\u5c14 - \\u51c9\\u51c9+\\u6843\\u82b1\\u6735\\u6735\\u5f00 (Live)\",\"timeLen\":216.095,\"privilege\":10,\"size\":3471568,\"album_id\":8339042,\"encrypt_id\":\"lz59w17\"},{\"Hash\":\"358946DC322F208E4B5DA6628D212918\",\"FileName\":\"Jessie J - Bang Bang+Price Tag (Live)\",\"timeLen\":328.083,\"privilege\":10,\"size\":5261687,\"album_id\":8339042,\"encrypt_id\":\"lz569f0\"},{\"Hash\":\"7B480F0AB4BDEF771242BF4E7A7CDB82\",\"FileName\":\"\\u6821\\u957f\\u3001\\u5f90\\u94b0\\u6606\\u3001\\u6df1\\u84dd\\u513f\\u7ae5\\u3001\\u96ea\\u78a7\\u8bf4\\u5531 - \\u56db\\u5b63\\u53d1\\u8d22\",\"timeLen\":220.068,\"privilege\":0,\"size\":3531511,\"album_id\":8342779,\"encrypt_id\":\"lyw93cc\"},{\"Hash\":\"5C75F20BD6B89C512B04542037585EB2\",\"FileName\":\"\\u6c6a\\u5cf0 - Mr.Man (Live)\",\"timeLen\":382.03,\"privilege\":10,\"size\":6117165,\"album_id\":8345464,\"encrypt_id\":\"lzc9ped\"},{\"Hash\":\"BDB6455FFBD21E7F47E05A33BB6541BF\",\"FileName\":\"VaVa - People On The Move\",\"timeLen\":185.01,\"privilege\":0,\"size\":2962302,\"album_id\":8344612,\"encrypt_id\":\"lz50u82\"},{\"Hash\":\"26C6295C2DA0430547A7BCCD99B42C93\",\"FileName\":\"\\u90c1\\u53ef\\u552f - \\u50cf\\u5c0f\\u65f6\\u5019\\u4e00\\u6837\\u3010\\u718a\\u51fa\\u6ca1\\u00b7\\u53d8\\u5f62\\u8bb0\\u7535\\u5f71\\u4e3b\\u9898\\u66f2\\u3011\",\"timeLen\":225.018,\"privilege\":0,\"size\":3603464,\"album_id\":8342895,\"encrypt_id\":\"lywpva5\"},{\"Hash\":\"5C125F46320913EFC48214ADCD0C14AA\",\"FileName\":\"\\u674e\\u8000\\u9633 - \\u522b\\u8bf4\\u518d\\u7ea6\",\"timeLen\":244.058,\"privilege\":0,\"size\":3914076,\"album_id\":8337574,\"encrypt_id\":\"lyfwj0c\"},{\"Hash\":\"D700A339560C4E04C29BAB4AD4AC2EF3\",\"FileName\":\"\\u5cb3\\u4e91\\u9e4f\\u3001\\u90ed\\u9e92\\u9e9f - \\u6f02\\u4eae\\u91cd\\u8981\\u5417\\u3010\\u7956\\u5b97\\u5341\\u4e5d\\u4ee3\\u7535\\u5f71\\u4e3b\\u9898\\u66f2\\u3011\",\"timeLen\":183.014,\"privilege\":0,\"size\":2930931,\"album_id\":8342316,\"encrypt_id\":\"lyx6g7a\"},{\"Hash\":\"02E3EAAC0A5B90620E55907DCE6BB364\",\"FileName\":\"\\u90a3\\u82f1 - \\u4e00\\u773c\\u5343\\u5e74\\u3010\\u56fd\\u5bb6\\u5b9d\\u85cf\\u7efc\\u827a\\u8282\\u76ee\\u4e3b\\u9898\\u66f2\\u3011\",\"timeLen\":221,\"privilege\":0,\"size\":3547183,\"album_id\":7813986,\"encrypt_id\":\"l0iund0\"},{\"Hash\":\"2D6688EA695F3B29F541398A6DF9FD15\",\"FileName\":\"Machine Gun Kelly\\u3001X Ambassadors\\u3001Bebe Rexha - Home\\u3010\\u5149\\u7075\\u7535\\u5f71\\u63d2\\u66f2\\u3011\",\"timeLen\":202,\"privilege\":10,\"size\":3236510,\"album_id\":6138263,\"encrypt_id\":\"jumuj13\"}];\n" +
                "\n" +
                "(function() {\n" +
                "\tvar apm = document.createElement(\"script\");\n" +
                "\tapm.src = \"http://js.webcollect.kugou.com/v2/web/collect.js?appid=2400\";\n" +
                "\tvar s = document.getElementsByTagName(\"script\")[0]; \n" +
                "\ts.parentNode.insertBefore(apm, s);\n" +
                "})();\n";
        //endregion
        RegexMatches.kuGouMain(js);
    }

}