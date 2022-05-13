import telebot
from telebot import types
import request

bot = telebot.TeleBot('5367104502:AAGidJIsdxDEUmzdwtm-XEfuzdy-7gy3ap8')


@bot.message_handler(commands=['start'])
def start_command(message):
    markup = types.ReplyKeyboardMarkup(resize_keyboard=True, row_width=1)
    createUniverse = types.KeyboardButton('Создать вселенную')
    markup.add(createUniverse)
    bot.send_message(message.chat.id, "Ну привет", reply_markup=markup)


@bot.message_handler()
def messages(message):
    def POMOGI_MNE_BOG(resp):
        print(resp)
        if resp == "WIN":
            msg = "ВЫ ПОБЕДИЛИ"
            return msg
        elif resp == "LOOSE":
            msg = "ВЫ ПРОИГРАЛИ"
            return msg
        else:
            string1 = ""
            string2 = ""
            for i in resp.get("enemyPlanetList"):
                string1 = f'{string1}\nНазвание планеты:{i.get("id")}.{i.get("planetName")}\nЗдоровье врага: {i.get("enemyHealthPoints")}\nСила врага: {i.get("enemyAttackPoints")}\n\n'
            for i in resp.get("playerPlanetList"):
                string2 = f'{string2}\nНазвание планеты: {i.get("planetName")}\nМеста для постройки: {i.get("buildingLimit")}\n\n'
            msg = f'ПЛАНЕТЫ ВРАГА: {string1}\nВАШИ ПЛАНЕТЫ: {string2}\nВАШИ РЕСУРСЫ:\n Здоровье вашей армии: {resp.get("resources").get("army").get("armyInfo").get("totalHealth")}\n Сила вашей армии: {resp.get("resources").get("army").get("armyInfo").get("totalDamage")}\n Ваше золото: {resp.get("resources").get("gold")}\n Ваши металлы: {resp.get("resources").get("metal")}\n Ваша еда: {resp.get("resources").get("food")}\n'
            return msg

    def attackPlanet(msgddddddd):
        num = int(msgddddddd.text)
        print(num)
        print("30")

        resp = POMOGI_MNE_BOG(request.send_attack_planet(msgddddddd.chat.id, num))
        if resp == "ВЫ ПОБЕДИЛИ":
            markup = types.ReplyKeyboardMarkup(resize_keyboard=True, row_width=1)
            createUniverse = types.KeyboardButton('Создать вселенную')
            markup.add(createUniverse)
            bot.send_message(message.chat.id,
                             resp,
                             reply_markup=markup)
            return
        if resp == "ВЫ ПРОИГРАЛИ":
            markup = types.ReplyKeyboardMarkup(resize_keyboard=True, row_width=1)
            createUniverse = types.KeyboardButton('Создать вселенную')
            markup.add(createUniverse)
            bot.send_message(message.chat.id,
                             resp,
                             reply_markup=markup)
            return
        else:
            markup = types.ReplyKeyboardMarkup(resize_keyboard=True, row_width=2)
            attackPlanet = types.KeyboardButton('Атаковать планету')
            manageResources = types.KeyboardButton('Управление ресурсами')
            markup.add(attackPlanet, manageResources)
            bot.send_message(message.chat.id,
                             resp,
                             reply_markup=markup)
            pass

    def addBuilding(msgaaaaaa):
        num = msgaaaaaa.text
        print(num)
        print("30")
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True, row_width=2)
        attackPlanet = types.KeyboardButton('Атаковать планету')
        manageResources = types.KeyboardButton('Управление ресурсами')
        markup.add(attackPlanet, manageResources)
        bot.send_message(message.chat.id,
                         POMOGI_MNE_BOG(request.send_hire_unit(2, msgaaaaaa.chat.id, num)),
                         reply_markup=markup)
        pass

    def hireUnit(msgsssssss):
        num = msgsssssss.text
        print(num)
        print("3")
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True, row_width=2)
        attackPlanet = types.KeyboardButton('Атаковать планету')
        manageResources = types.KeyboardButton('Управление ресурсами')
        markup.add(attackPlanet, manageResources)
        bot.send_message(message.chat.id,
                         POMOGI_MNE_BOG(request.send_hire_unit(4, msgsssssss.chat.id, num)),
                         reply_markup=markup)
        pass

    if message.text == "Создать вселенную":
        # request.send_create_universe(message.chat.id)
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True, row_width=2)
        attackPlanet = types.KeyboardButton('Атаковать планету')
        manageResources = types.KeyboardButton('Управление ресурсами')
        markup.add(attackPlanet, manageResources)
        bot.send_message(message.chat.id,
                         POMOGI_MNE_BOG(request.send_create_universe(message.chat.id)),
                         reply_markup=markup)
        return

    if message.text == "Атаковать планету":
        msg = bot.send_message(message.chat.id,
                               "Выберите планету и введите ее порядковый номер")
        print("500")
        bot.register_next_step_handler(message, attackPlanet)
        return

    if message.text == "Управление ресурсами":
        markup = types.ReplyKeyboardMarkup(resize_keyboard=True, row_width=1)
        hireUnit = types.KeyboardButton('Нанять юнита')
        addBuilding = types.KeyboardButton('Построить здание')
        # removeBuilding = types.KeyboardButton('Снести здание')
        markup.add(hireUnit, addBuilding)  # , removeBuilding)
        bot.send_message(message.chat.id, "Управление ресурсами", reply_markup=markup)
        return

    if message.text == "Нанять юнита":
        msg = bot.send_message(message.chat.id,
                               "1.Воин\nСила атаки:2\nЗдоровье:4\n \n2.Стрелок\nСила атаки:4\nЗдоровье:2\n \n3.Танк\nСила атаки:5\nЗдоровье:10")
        print("1")
        bot.register_next_step_handler(message, hireUnit)
        return

    if message.text == "Построить здание":
        msg = bot.send_message(message.chat.id,
                               "1.Ферма\nПрирост еды:100\nЦена:\nЗолото/Металлы/Еда\n50/50/0\n \n2.Шахта\nПрирост металлов:100\nЦена:\nЗолото/Металлы/Еда\n50/0/50\n \n3.Банк\nПрирост золота:100\nЦена:\nЗолото/Металлы/Еда\n0/50/50\n")
        print("10")
        bot.register_next_step_handler(message, addBuilding)
        return

    print(message.text)
    bot.send_message(message.chat.id, "Ты по-моему перепутал...")


bot.polling(none_stop=True)

if __name__ == '__main__':
    bot.infinity_polling()
