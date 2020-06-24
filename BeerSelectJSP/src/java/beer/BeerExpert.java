package beer;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fhcmartins
 */
public class BeerExpert {
    public List<String> getBrands(String estilo) {
        List<String> brands = new ArrayList<>();
        
        if (estilo.equals("American Brown Ale")) {
            brands.add("<h2>American Brown Ale</h2>");
            
            brands.add("<strong>Impressão Geral: </strong>");
            brands.add("<br><br>Uma cerveja maltada, mas lupulada, frequentemente com sabores de chocolate e caramelo."
                    + "<br> O sabor e o aroma do lúpulo complementam e melhoram a percepção do malte, ao invés de confrontá-lo.");
            
            brands.add("<br><br><strong>Aparência</strong>");
            brands.add("<br><br> Cor castanho claro a muito escuro. Límpida. Espuma em tom bege claro a bege escuro, próxima ao bronzeado, de formação moderada.");
            
            brands.add("<br><br><strong>Ingredientes Característicos</strong>");
            brands.add("<br><br>Malte Pale bem modificado, além de Cristal e maltes escuros (normalmente o Chocolate)."
                    + "<br>Lúpulos americanos são típicos, mas os Continentais ou os do Novo Mundo também podem ser usados.");
            
            brands.add("<br><br><strong>Comparação de estilos</strong>");
            brands.add("<br><br>Mais sabor de chocolate e caramelo que as American Pale Ales ou Amber Ale, tipicamente com menos"
                    + "<br>amargor de destaque no balanço. Menos amargor, álcool, e caráter de lúpulo do que as Brown IPAs. Mais amarga e,"
                    + "<br>geralmente, mais lupulada do que as English Brown Ales, com uma presença mais intensa de malte, geralmente mais"
                    + "<br>álcool e caráter de lúpulos americanos ou do Novo Mundo.");
            
            brands.add("<br><br><strong>Maiores Informações em </strong>");
            brands.add("<a href='https://www.levteck.com.br/tipo_de_cerveja/american-brown-ale/' target='_blank'>https://www.levteck.com.br/tipo_de_cerveja/american-brown-ale/</a>");
        }
        else if (estilo.equals("Belgian Blond Ale")){
            brands.add("<h2>Belgian Blond Ale</h2>");
            
            brands.add("<strong>Impressão Geral: </strong>");
            brands.add("<br><br>Uma ale dourada, de intensidade moderada, que tem uma complexidade sutil frutada-picante,"
                    + "<br> de levedura belga, com um pouco de sabor de malte doce e um final seco.");
            
            brands.add("<br><br><strong>Aparência</strong>");
            brands.add("<br><br>Cr dourada, de claro a profundo. No geral muito límpida. Espuma alta, densa e cremosa, de cor branca a bege clarinho."
                    + "<br>Boa retenção com Belgian Lace (rendado belga, fixado na parede da taça, enquanto a espuma desaparece).");
            
            brands.add("<br><br><strong>Ingredientes Característicos</strong>");
            brands.add("<br><br>Malte Pils belga, maltes aromáticos, açúcar, cepas de leveduras belgas que produzem álcoois complexos, compostos fenólicos"
                    + "<br>e ésteres perfumados, lúpulos nobres dos varietais Saaz, Styrian Goldings e East Kent Golding. Tradicionalmente não se utilizam"
                    + "<br>especiarias, embora os ingredientes e subprodutos da fermentação podem dar uma impressão de temperos (muitas vezes uma"
                    + "<br>reminiscência a laranjas ou limões). Se as especiarias estão presentes, só devem ser como um caráter de fundo.");
            
            brands.add("<br><br><strong>Maiores Informações em </strong>");
            brands.add("<a href='https://www.levteck.com.br/tipo_de_cerveja/belgian-blond-ale/' target='_blank'>https://www.levteck.com.br/tipo_de_cerveja/belgian-blond-ale/</a>");
            
        }
        else if (estilo.equals("Lambic Fruit")){
            brands.add("<h2>Lambic Fruit</h2>");
            
            brands.add("<strong>Impressão Geral: </strong>");
            brands.add("<br><br>Uma cerveja de trigo Wild complexa, frutada, agradavelmente ácida, fermentada por uma variedade de microbiota belga, e apresentando as contribuições"
                    + "<br>de frutas misturadas com o caráter wild. O tipo de fruta pode às vezes ser difícil de identificar como características fermentadas e envelhecidas que"
                    + "<br>podem parecer diferentes dos aromas e sabores mais reconhecíveis da frutas fresca.");
            
            brands.add("<br><br><strong>Aparência</strong>");
            brands.add("<br><br>A variedade da fruta geralmente determina a cor, embora frutas de cor mais claras podem ter pouco efeito sobre a cor. A intensidade da cor pode"
                    + "<br>desaparecer com o envelhecimento. A transparência é frequentemente boa, embora algumas frutas não vão deixá-la brilhante. Uma espuma compacta, espessa,"
                    + "<br>como a mousse, às vezes com um tom de cor da fruta, é geralmente de longa duração (dependente da carbonatação). A carbonatação é geralmente elevada,"
                    + "<br>mas deve ser especificada na ficha de inscrição.");
            
            brands.add("<br><br><strong>Ingredientes Característicos</strong>");
            brands.add("<br><br>É utilizado trigo não maltado (30-40%), malte Pilsner e lúpulo envelhecido (3 anos). Os lúpulos envelhecidos são usados mais para efeitos conservantes"
                    + "<br>do que para amargor, fazendo com que os níveis reais de amargor sejam difíceis de estimar. Os produtos tradicionais utilizam 10-30% de fruta (25%, se for cereja)."
                    + "<br>As frutas utilizadas tradicionalmente usadas incluem cerejas ácidas (com buracos), framboesas ou uvas Moscatel. Exemplos mais recentes incluem pêssegos, damascos"
                    + "<br>ou uvas Merlot. Tradicionalmente se utilizam frutas acres ou ácidas pois sua finalidade não é adoçar a cerveja, mas sim para adicionar uma nova dimensão."
                    + "<br>Tradicionalmente, essas cervejas são espontaneamente fermentadas com leveduras e bactérias de origem natura, encontradas no ambiente, predominantemente em barricas de carvalho."
                    + "<br>Os barris usados são antigos e têm pouco caráter carvalho, então não espere um caráter de carvalho fresco ou nessa linha – um caráter mais neutro é típico. As versões caseiras e"
                    + "<br>artesanais são tipicamente elaboradas com culturas puras de levedura normalmente incluindo Saccharomyces, Brettanomyces, Pediococcus e Lactobacillus, numa tentativa de recriar"
                    + "<br>os efeitos da microbiota dominante em Bruxelas e nos arredores do Vale do Rio Senna. As culturas retiradas de garrafas são por vezes utilizadas, mas não há nenhuma maneira simples"
                    + "<br>de se saber se os organismos ainda são viáveis.");
            
            brands.add("<br><br><strong>Maiores Informações em </strong>");
            brands.add("<a href='https://www.levteck.com.br/tipo_de_cerveja/fruit-lambic/' target='_blank'>https://www.levteck.com.br/tipo_de_cerveja/fruit-lambic/</a>");
        }
        else if (estilo.equals("Witbier")){
            brands.add("<h2>Witbier</h2>");
            
            brands.add("<strong>Impressão Geral: </strong>");
            brands.add("<br><br>Uma ale à base de trigo, refrescante, elegante, saborosa, de moderada intensidade.");
            
            brands.add("<br><br><strong>Aparência</strong>");
            brands.add("<br><br>Cor amarelo palha muito pálido ao dourado muito claro. A cerveja é muito turva em razão do amido dos grãos e/ou leveduras, o que lhe dá uma aparência leitosa,"
                    + "<br>esbranquiçada-amarelado. Espuma denso, branca, como de mousse. A retenção de espuma deve ser muito boa.");
            
            brands.add("<br><br><strong>Ingredientes Característicos</strong>");
            brands.add("<br><br>Cerca de 50% de trigo não maltado e 50% de malte de cevada claro (geralmente malte Pils) constituem a moagem. Em algumas versões, até 5-10% pode ser usado aveia crua."
                    + "<br>Especiarias de semente de coentro recém moído e Curaçao ou, às vezes, casca de laranja doce complementam o aroma doce e são muito característicos. Outras especiarias"
                    + "<br>(por exemplo, camomila, cominho, canela, pimenta-da-guiné) podem ser utilizados para dar complexidade, mas são muito menos proeminentes. A levedura Ale propensa à produção"
                    + "<br>de sabores condimentados suaves são muito característicos. Em alguns casos, é realizada uma fermentação láctica muito limitada, ou a adição real de ácidos lácticos.");
            
            brands.add("<br><br><strong>Maiores Informações em </strong>");
            brands.add("<a href='https://www.levteck.com.br/tipo_de_cerveja/witbier/' target='_blank'>https://www.levteck.com.br/tipo_de_cerveja/witbier/</a>");
        }
        
        return brands;
    }
    
}
