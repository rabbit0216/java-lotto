package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
       sizeValidate(numbers);
       inputValidate(numbers);
       redundantValidate(numbers);
    }

    private void sizeValidate(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 로또 번호 개수는 6개여야 합니다.");
        }
    }

    private void inputValidate(List<Integer> numbers){
        for(Integer number : numbers){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("[Error] 로또 번호는 1에서 45여야 합니다.");
            }
        }
    }

    private void redundantValidate(List<Integer> numbers){
        for(Integer number : numbers){
            int numberFrequency = Collections.frequency(numbers, number);
            if(numberFrequency > 1){
                throw new IllegalArgumentException("[Error] 로또 번호는 중복되지 않아야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
}
