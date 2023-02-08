import java.util.HashMap;
import java.util.Map;

public class ResultService {
    private final Map<Integer, Integer> resultCounter = new HashMap<>();
    private final String[] categoryDescriptions = new String[6];
    private final String[] pointsDescriptions = new String[4];

    public ResultService() {
        resultCounter.put(1, 0);
        resultCounter.put(2, 0);
        resultCounter.put(3, 0);
        resultCounter.put(4, 0);
        resultCounter.put(5, 0);
        resultCounter.put(6, 0);
        setDescriptions();
        setPointsDescriptions();
    }

    public void put(Answer answer) {
        switch (answer.id()) {
            case 1:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(1, resultCounter.get(1) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(4, resultCounter.get(4) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(6, resultCounter.get(6) + 1);
                break;
            case 2:
            case 9:
            case 14:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(2, resultCounter.get(2) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(4, resultCounter.get(4) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(5, resultCounter.get(5) + 1);
                break;
            case 3:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(1, resultCounter.get(1) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(2, resultCounter.get(2) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(4, resultCounter.get(4) + 1);
                break;
            case 4:
            case 19:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(3, resultCounter.get(3) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(5, resultCounter.get(5) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(6, resultCounter.get(6) + 1);
                break;
            case 5:
            case 11:
            case 18:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(1, resultCounter.get(1) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(2, resultCounter.get(2) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(3, resultCounter.get(3) + 1);
                break;
            case 6:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(1, resultCounter.get(1) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(2, resultCounter.get(2) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(6, resultCounter.get(6) + 1);
                break;
            case 7:
            case 21:
            case 22:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(2, resultCounter.get(2) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(3, resultCounter.get(3) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(4, resultCounter.get(4) + 1);
                break;
            case 8:
            case 13:
            case 24:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(1, resultCounter.get(1) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(5, resultCounter.get(5) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(6, resultCounter.get(6) + 1);
                break;
            case 10:
            case 17:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(4, resultCounter.get(4) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(5, resultCounter.get(5) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(6, resultCounter.get(6) + 1);
                break;
            case 12:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(3, resultCounter.get(3) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(4, resultCounter.get(4) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(5, resultCounter.get(5) + 1);
                break;
            case 15:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(1, resultCounter.get(1) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(3, resultCounter.get(3) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(5, resultCounter.get(5) + 1);
                break;
            case 16:
            case 20:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(1, resultCounter.get(1) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(3, resultCounter.get(3) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(6, resultCounter.get(6) + 1);
                break;
            case 23:
                if (answer.pointer().equals(Pointers.A)) resultCounter.put(2, resultCounter.get(2) + 1);
                else if (answer.pointer().equals(Pointers.B)) resultCounter.put(4, resultCounter.get(4) + 1);
                else if (answer.pointer().equals(Pointers.C)) resultCounter.put(6, resultCounter.get(6) + 1);
                break;
        }
    }

    public Result[] getResults() {
        Result[] results = new Result[6];
        for (int i = 0; i <= 5; i++) {
            int points = resultCounter.get(i + 1);
            String pointsDescription;
            if (points >= 0 && points <= 3) pointsDescription = pointsDescriptions[0];
            else if (points >= 4 && points <= 6) pointsDescription = pointsDescriptions[1];
            else if (points >= 7 && points <= 9) pointsDescription = pointsDescriptions[2];
            else if (points >= 10 && points <= 12) pointsDescription = pointsDescriptions[3];
            else pointsDescription = "Ошибка в расчетах!";
            results[i] = new Result(i + 1, categoryDescriptions[i], points, pointsDescription);
        }
        return results;
    }

    private void setDescriptions() {
        categoryDescriptions[0] = "Склонность к работе с людьми. " +
                "Профессии, связанные с управлением, обучением, воспитанием, обслуживанием " +
                "(бытовым, медицинским, справочно-информационным). " +
                "Людей, успешных в профессиях этой группы, отличает общительность, способность находить общий язык " +
                "с разными людьми, понимать их настроение, намерения.";
        categoryDescriptions[1] = "Склонность к исследовательской (интеллектуальной) работе. " +
                "Профессии, связанные с научной деятельностью. " +
                "Кроме специальных знаний такие люди обычно отличаются рациональностью, независимостью суждений, " +
                "аналитическим складом ума.";
        categoryDescriptions[2] = "Склонность к практической деятельности. " +
                "Круг этих профессий очень широк: производство и обработка металла; " +
                "сборка, монтаж приборов и механизмов; ремонт, наладка, обслуживание электронного и механического " +
                "оборудования; монтаж, ремонт зданий, конструкций; управление транспортом; изготовление изделий. ";
        categoryDescriptions[3] = "Склонность к эстетическим видам деятельности. " +
                "Профессии творческого характера, связанные с изобразительной, музыкальной, литературно-художественной, " +
                "актерско-сценической деятельностью. Людей творческих профессий кроме специальных способностей " +
                "(музыкальных, литературных, актерских) отличает оригинальность и независимость.";
        categoryDescriptions[4] = "Склонность к экстремальным видам деятельности. " +
                "Профессии, связанные с занятиями спортом, путешествиями, экспедиционной работой, охранной и " +
                "оперативно-розыскной деятельности, службой в армии. Все они предъявляют особые требования к " +
                "физической подготовке, здоровью, волевым качествам.";
        categoryDescriptions[5] = "Склонность к планово-экономическим видам деятельности. " +
                "Профессии, связанные с расчетами и планированием (бухгалтер, экономист); делопроизводством, " +
                "анализом текстов и их преобразованием (редактор, переводчик, лингвист); схематическим изображением " +
                "объектов (чертежник, топограф). Эти профессии требуют от человека собранности и аккуратности.";
    }

    private void setPointsDescriptions() {
        pointsDescriptions[0] = "профессиональная склонность не выражена.";
        pointsDescriptions[1] = "слабо выраженная профессиональная склонность.";
        pointsDescriptions[2] = "склонность к определенному виду деятельности.";
        pointsDescriptions[3] = "ярко выраженная профессиональная склонность.";
    }
}

// TODO можно сделать сортировку по количеству баллов и выдавать результаты по убыванию.

