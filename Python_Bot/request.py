import requests


def send_request():
    URL = "http://localhost:3001/createUniverse"
    r = requests.get(URL)
    data = r.json()
    return data

def send_attack_planet(telegramId, planetId):
    payload = {'telegramId': telegramId, 'planetId': planetId}
    URL = "http://localhost:3001/attackPlanet"
    r = requests.get(URL, params=payload)
    data = r.json()
    return data

def send_hire_unit(operation, telegramId, unitId):
    payload = {'operation': operation, 'telegramId': telegramId, 'unitId': unitId}
    URL = "http://localhost:3001/manageResources"
    r = requests.get(URL, params=payload)
    data = r.json()
    return data


def send_create_universe(telegramId):
    payload = {'telegramId': telegramId}
    URL = "http://localhost:3001/createUniverse"
    r = requests.get(URL, params=payload)
    data = r.json()
    return data
