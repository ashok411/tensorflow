package com.example.tensorflow;

import org.tensorflow.Tensor;
import org.tensorflow.Session;
import org.tensorflow.TensorFlow;

import static org.tensorflow.TensorFlow.*;

public class LlmModel {

    private Session session;

    public LlmModel(byte[] modelBytes) {
        session = TensorFlow.loadLibrary().createSession();

        // Restore the model from the model.pb file.
        session.run(new Tensor(modelBytes));
    }

    public String generateText(String prompt) {
        // Create a Tensor object for the prompt.
        Tensor promptTensor = Tensor.create(prompt);

        // Generate the text.
        Tensor generatedTextTensor = session.run("output:0", feedMap={"input:0": promptTensor});

        // Return the generated text.
        return generatedTextTensor.stringValue();
    }
}
