import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

import static ru.yandex.praktikum.page.objects.MainPage.*;

@RunWith(Parameterized.class)
public class DropdownTest extends BaseClassTest {

    private final int questionIndex;
    private final int answerIndex;
    private final String answerText;
    private final String questionText;

    public DropdownTest(int questionIndex, String questionText, int answerIndex, String answerText) {
        this.questionIndex = questionIndex;
        this.answerIndex = answerIndex;
        this.answerText = answerText;
        this.questionText = questionText;
    }

    @Parameterized.Parameters
    public static Object[][] expectedAnswersParamList() {
        return new Object[][]{
                {0, HOW_MUCH_QUESTION, 0, HOW_MUCH_ANSWER},
                {1, MANY_SCOOTERS_QUESTION, 1, MANY_SCOOTERS_ANSWER},
                {2, RENT_TIME_QUESTION, 2, RENT_TIME_ANSWER},
                {3, TODAY_RENT_QUESTION, 3, TODAY_RENT_ANSWER},
                {4, EXTEND_ORDER_QUESTION, 4, EXTEND_ORDER_ANSWER},
                {5, CHARGE_FOR_SCOOTER_QUESTION, 5, CHARGE_FOR_SCOOTER_ANSWER},
                {6, CANCEL_ORDER_QUESTION, 6, CANCEL_ORDER_ANSWER},
                {7, LIVE_MKAD_QUESTION, 7, LIVE_MKAD_ANSWER}
        };
    }

    @Test
    public void checkDropdownTextTest() {

        mainPage.scrollPageToFAQ()
                .clickQuestionsFAQ(questionIndex);

        Assert.assertEquals("Текст в вопросе должен быть другим", questionText, mainPage.getQuestionText(questionIndex));
        Assert.assertEquals("Текст в ответе должен быть другим", answerText, mainPage.getAnswerText(answerIndex));
    }
}