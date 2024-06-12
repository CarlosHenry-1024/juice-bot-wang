pip install Flask

from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/webhook', methods=['POST'])
def webhook():
    req = request.json
    intent = req.get('intent')
    
    if intent == '/hello':
        return jsonify({"response": "你好！我是您的助手。您可以问我天气情况或汇率信息。"})
    elif intent == '/weather':
        return jsonify({"response": "请告诉我您想查询天气的城市。"})
    elif intent == '/currency':
        return jsonify({"response": "请告诉我您想查询的货币对（例如，美元对欧元）。"})
    else:
        return jsonify({"response": "抱歉，我不太明白您的意思。您可以尝试问我天气或汇率信息。"})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)


from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/webhook', methods=['POST'])
def webhook():
    req = request.json
    message = req.get('message', '').lower()
    
    if 'hello' in message or 'hi' in message:
        return jsonify({"response": "你好！我是您的助手。您可以问我天气情况或汇率信息。"})
    elif 'weather' in message or '天气' in message:
        return jsonify({"response": "请告诉我您想查询天气的城市。"})
    elif 'currency' in message or '汇率' in message:
        return jsonify({"response": "请告诉我您想查询的货币对（例如，美元对欧元）。"})
    else:
        return jsonify({"response": "抱歉，我不太明白您的意思。您可以尝试问我天气或汇率信息。"})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
