from xml.etree import cElementTree as Et

tree = Et.parse('../data/chp3/data-text.xml')
root = tree.getroot()
print type(root)
data = root.find('Data')
print type(data)
all_data = []
for observation in data:
    print type(observation)
    record = {}
    for item in observation:
        print type(item)
        lookup_key = item.attrib.keys()[0]
        if lookup_key == 'Numeric':
            rec_key = 'NUMERIC'
            rec_value = item.attrib['Numeric']
        else:
            rec_key = item.attrib[lookup_key]
            rec_value = item.attrib['Code']

        record[rec_key] = rec_value

    all_data.append(record)

# print '\n'.join((str(v) for v in all_data))
