import json

json_data = open('../data/chp3/data-text.json', 'rb').read()
data = json.loads(json_data)
for item in data:
    print item