package viewmodel;

import factory.QuestionFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.QuestionModel;
import service.QuestionStore;

import java.util.ArrayList;
import java.util.List;

public class NewQuestionViewModel {
    private final StringProperty label = new SimpleStringProperty();
    private final StringProperty answer = new SimpleStringProperty();
    private final StringProperty options = new SimpleStringProperty();

    public StringProperty getLabel(){
        return this.label;
    }

    public StringProperty getAnswer() {
        return this.answer;
    }

    public StringProperty getOptions(){
        return this.options;
    }

    public void createQuestion(){
        QuestionFactory questionFactory = new QuestionFactory();
        QuestionModel question = questionFactory.createQuestion(
                label.get(),
                answer.get(),
                new ArrayList<>(List.of(options.get().split(",")))
        );
        QuestionStore.getInstance().addQuestion(question);
    }
}
