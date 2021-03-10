package com.gayedirican.odev1_ennurgayedirican
import java.util.*
import kotlin.random.Random
import java.util.Scanner as Scanner

fun main(){
    odevSecici()
}
fun odevSecici(){
    val sayiInput = Scanner(System.`in`)
    while(true){
    print("\n Ödev-1 için 1'e, \n Ödev-2 için 2'ye, \n Ödev-3 için 3'e, \n Ödev-4 için 4'e, \n Çıkmak için 0'a basınız. \n")
    val secim = sayiInput.nextInt()

    if(secim==1){
        println("-------------------------")
        println("ÖDEV-1: ASAL SAYI KONTROLÜ")
        asalSayi()
        continue
    } else if(secim==2) {
        println("-------------------------")
        println("ÖDEV-2: HARF NOTU HESAPLAYICI")
        harfNotuHesaplayici()
        continue
    }else if(secim==3) {
        println("-------------------------")
        println("ÖDEV-3: GÜN HESAPLAYICI")
        gunHesaplayici()
        continue
    }else if(secim==4) {
        println("-------------------------")
        println("ÖDEV-4: RANDOM SAYI TAHMİNİ")
        tahmin()
        continue
    } else{break}}
}
/* Ödev 1
    Döngüler kullanarak asal sayı kontrol eden bir algoritma yazınız.

        -Kullanıcıdan sayı alınsın
        -For veya while döngüsüyle Asal olup olmadığını kontrol etsin

 */
fun asalSayi(){
    val sayiInput = Scanner(System.`in`)
    print("Bir sayı giriniz: ")
    val girilenSayi = sayiInput.nextInt()
    var sayac=0
    if(girilenSayi<=1){
        println("Bu sayı için asallık hesabı yapılamaz!");
    }
    else{
        for(i in 1..girilenSayi)
        {
            val kalan=girilenSayi%i;
            if(kalan==0){
                sayac++;
            }
        }
        if(sayac==2){
            println("Sayı asaldır!");
        }
        else{
            println("Sayı asal değildir!");
        }
    }
}


/* Ödev 2
    When kullanarak harf notu hesaplayan bir algoritma yazınız

        -Kullanıcıdan vize ve final notlarını istesin
        -Ortalama hesaplasın
        -Ortalamaya göre geçip kaldıklarını yazsın
        -Çıktılara göre yazılacaklar:

            0-49 FF
            50-60 DD
            60-70 CC
            70-80 BB
            80-100 AA
 */
fun harfNotuHesaplayici(){
    val sayiInput = Scanner(System.`in`)
    println("Vize notunuzu giriniz(virgüllü sayı girebilirsiniz): ")
    val vizeNotu = sayiInput.nextFloat()
    println("Final notunuzu giriniz(virgüllü sayı girebilirsiniz): ")
    val finalNotu = sayiInput.nextFloat()

    val ortalama:Int = ((vizeNotu*0.6) + (finalNotu*0.4)).toInt()
    println("Ortalamanız: $ortalama")
    when(ortalama) {
        in 80..100 -> println("AA")
        in 70..80 -> println("BB")
        in 60..70 -> println("CC")
        in 50..60 -> println("DD")
        else -> println("FF")

    }

}
/* ödev 3
    Bu gün günlerden çarşamba olduğunu varsayalım kullanıcıdan sayı alıp aldığı sayı kadar gün
    geçtiğinde günlerden hangi gün olduğunu söyleyen bir algoritma yazınız.

        -Kullanıcıdan bir sayı alsın
        -When kullanarak alınan sayıya göre girilen sayı kadar gün sonra hangi güne denk geleceğini söylesin
        -7 den büyük girilen sayılar içinde hesaplamaya devam etsin(dersteki örneğin aksine)

        örnek: girdi: 2 - çıktı: 2 gün sonra günlerden Cuma

 */
fun gunHesaplayici(){
    val sayiInput = Scanner(System.`in`)
    println("Bugün günlerden Çarşamba. Kaç gün sonrasını hesaplamak istersiniz?")
    val gun = sayiInput.nextInt()
    val mod = gun%7
    when(mod){
        0->println("$gun Gün sonra günlerden Çarşamba")
        1->println("$gun Gün sonra günlerden Perşembe")
        2->println("$gun Gün sonra günlerden Cuma")
        3->println("$gun Gün sonra günlerden Cumartesi")
        4->println("$gun Gün sonra günlerden Pazar")
        5->println("$gun Gün sonra günlerden Pazartesi")
        6->println("$gun Gün sonra günlerden Salı")

    }
}
/* Ödev 4
    1 ile 100 arasında rastgele bir sayı seçilsin kullanıcıdan bu sayının bulunması istenilsin.
    Kullanıcının bilmek için 3 hakkı olsun

        -Kullanıcıya 3 tahmin hakkı verilsin
        -Program random 1 sayı seçsin
        -Kullanıcıdan tahmin için sayı istesin
        -Girilen sayı random sayıdan büyükse daha küçük, küçükse daya büyük bir sayı deneyin diye
         çıktı versin ve 1 tahmin hakkı düşürsün, kalan hakkı göstersin
        -Tahmin hakkı kaldığı sürece tekrar sayı istesin
        -Tahmin hakkı bittiğinde program hakkınız bitti yazıp kapansın
        -Doğru tahmin edildiğinde Program tebrik edip kapansın

 */
fun tahmin() {
    val randomSayi = (1..100).random()
    val sayiInput = Scanner(System.`in`)
    var tahminHakki = 3
    do {
        tahminHakki--
        println("1 ile 100 arasında bir sayı giriniz: ")
        val tahmin = sayiInput.nextInt()
        if (tahmin > randomSayi) {
            if(tahminHakki==0){
                println("Yanlış değer girdiniz!\n Kalan hakkınız $tahminHakki!\n ")
            } else{println("Yanlış değer girdiniz!\n Kalan hakkınız $tahminHakki!\n Daha küçük bir sayı girin!: ")}

        } else if (tahmin < randomSayi) {
            if(tahminHakki==0){
                println("Yanlış değer girdiniz!\n Kalan hakkınız $tahminHakki!\n")
            } else{println("Yanlış değer girdiniz!\n Kalan hakkınız $tahminHakki!\n Daha büyük bir sayı girin!: ")}
        } else{
            println("Tebrikler")
        }
    } while (tahminHakki != 0)

    println("Üretilen sayı $randomSayi")
}


