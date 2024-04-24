# Installing Mistral

To install Mistral or LLAMA 3, we will use [ollama](https://ollama.ai/).
Download ollama from [ollama's download page](https://ollama.ai/download) and follow the installation instructions.

Once installed, you should have access to the `ollama` command line tool:

```bash
$©
ollama version is 0.1.17
```

Ollama can run multiple models, as you can see on [ollama's library](https://ollama.ai/library).
We will use the `mistral` model, which is a Mistral is a 7B model, and we are choosing this one to have a corresponding type of models that the one we hosted on Openshift AI
For that, you first need to start the ollama server:

```bash
$ ollama serve 
```

Then, pull the model using:

```bash
$ ollama pull llama2 
```

???+ warning  
    The [LLAMA2](https://ollama.ai/library/llama2) model is quite large (> 3.8GB). Make sure you have enough disk space.

You can check the list of available models using:

```bash
$ ollama list
NAME          	ID          	SIZE  	MODIFIED
llama3:latest 	a6990ed6be41	4.7 GB	55 seconds ago
mistral:latest	61e88e884507	4.1 GB	12 minutes ago
```

Once pulled, we will be able to use it.
