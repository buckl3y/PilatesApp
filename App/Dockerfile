FROM node:18

WORKDIR /usr/app/

COPY ./nodejs/package.json .

RUN npm install --quiet

COPY ./nodejs .

EXPOSE 3000

CMD ["npm", "start"]